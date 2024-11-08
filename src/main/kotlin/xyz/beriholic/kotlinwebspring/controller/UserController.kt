package xyz.beriholic.kotlinwebspring.controller

import cn.dev33.satoken.stp.StpUtil
import cn.hutool.core.util.IdUtil
import org.springframework.web.bind.annotation.*
import xyz.beriholic.kotlinwebspring.model.None
import xyz.beriholic.kotlinwebspring.model.Results
import xyz.beriholic.kotlinwebspring.model.entity.dto.UserInfo
import xyz.beriholic.kotlinwebspring.model.entity.dto.UserLoginInput
import xyz.beriholic.kotlinwebspring.model.entity.dto.UserRegisterInput
import xyz.beriholic.kotlinwebspring.model.repository.UserRepository

@RestController
@RequestMapping("/user")
class UserController(
    private val tBUserRepository: UserRepository,
) {

    @PostMapping("/register")
    fun userRegister(
        @RequestBody req: UserRegisterInput,
    ): Results<None> {
        val username = req.username
        val password = req.password

        if (username.isNullOrBlank() || password.isBlank()) {
            return Results.fail(msg = "参数无效")
        }

        val uid = IdUtil.getSnowflakeNextId()

        val dbUser = tBUserRepository.findUser(
            uname = username,
        )

        if (dbUser.isNotEmpty()) {
            return Results.fail(
                msg = "用户名已存在"
            )
        }

        tBUserRepository.newUser(
            uid = uid,
            name = username,
            passwd = password
        )

        return Results.ok()
    }

    @PostMapping("/login")
    fun userLogin(
        @RequestBody req: UserLoginInput,
    ): Results<Long> {
        val username = req.username
        val password = req.password

        if (username.isNullOrBlank() || password.isBlank()) {
            return Results.fail(msg = "参数无效")
        }

        val dbUsers = tBUserRepository.findUser(
            uname = username,
            passwd = password
        )

        if (dbUsers.size != 1) {
            return Results.fail(msg = "用户名或密码错误")
        }


        val id = dbUsers.first().id
        StpUtil.login(id)
        StpUtil.getSession().set("username", username)

        return Results.ok(data = id)
    }


    @GetMapping("/alive")
    fun isLogin(): Results<Boolean> {
        return Results.ok(data = StpUtil.isLogin())
    }

    @PostMapping("/logout")
    fun logOut(): Results<None> {
        StpUtil.logout()
        return Results.ok()
    }


    @GetMapping("/info")
    fun userInfo(): Results<UserInfo> {
        val id = StpUtil.getLoginIdAsLong();
        val username = StpUtil.getSession().get("username").toString()


        return Results.ok(data = UserInfo(id = id, username = username))
    }
}