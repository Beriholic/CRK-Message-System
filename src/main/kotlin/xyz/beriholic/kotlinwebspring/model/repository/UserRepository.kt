package xyz.beriholic.kotlinwebspring.model.repository

import org.babyfish.jimmer.sql.fetcher.Fetcher
import org.babyfish.jimmer.sql.kt.KSqlClient
import org.babyfish.jimmer.sql.kt.ast.expression.`eq?`
import org.springframework.stereotype.Repository
import xyz.beriholic.kotlinwebspring.model.entity.User
import xyz.beriholic.kotlinwebspring.model.entity.id
import xyz.beriholic.kotlinwebspring.model.entity.password
import xyz.beriholic.kotlinwebspring.model.entity.username

/**
 * <p>
 * TbUserRepository 接口
 * </p>
 *
 * @author w2h34d
 * @date 2024-10-31
 */
@Repository
class UserRepository(private val sql: KSqlClient) {
    fun newUser(
        uid: Long,
        name: String,
        passwd: String,
    ) {
        sql.save(
            User {
                id = uid
                username = name
                password = passwd
            }
        )
    }

    fun findUser(
        id: Long? = null,
        uname: String? = null,
        passwd: String? = null,
        fetcher: Fetcher<User>? = null,
    ): List<User> {
        return sql.createQuery(User::class) {
            where(table.id.`eq?`(id))
            where(table.username.`eq?`(uname))
            where(table.password.`eq?`(passwd))
            select(table.fetch(fetcher))
        }.execute()
    }
}

