package xyz.beriholic.kotlinwebspring.controller

import cn.dev33.satoken.stp.StpUtil
import org.babyfish.jimmer.client.FetchBy
import org.springframework.web.bind.annotation.*
import xyz.beriholic.kotlinwebspring.model.None
import xyz.beriholic.kotlinwebspring.model.Results
import xyz.beriholic.kotlinwebspring.model.entity.Comment
import xyz.beriholic.kotlinwebspring.model.entity.dto.BaseComment
import xyz.beriholic.kotlinwebspring.model.entity.dto.CreateCommentInput
import xyz.beriholic.kotlinwebspring.model.repository.CommentRepository

@RestController
class CommentController(private val commentRepository: CommentRepository) {
    @GetMapping("/comments")
    fun getComments(
        @RequestParam("size") size: Int,
        @RequestParam("offset") offset: Long,
    ): Results<List<@FetchBy("BASE_COMMENT") Comment>> {
        val commentList = commentRepository.findComments(
            fetcher = BaseComment.METADATA.fetcher,
            size = size,
            offset = offset
        )

        return Results.ok(data = commentList)
    }

    @PostMapping("/comment/new")
    fun newComment(
        @RequestBody input: CreateCommentInput,
    ): Results<None> {
        val uid = StpUtil.getLoginIdAsLong()
        val username = StpUtil.getSession().get("username").toString()

        commentRepository.newComment(
            uid = uid,
            username = username,
            content = input.content
        )

        return Results.ok()
    }

    companion object {
        private val BASE_COMMENT = BaseComment.METADATA.fetcher
    }
}