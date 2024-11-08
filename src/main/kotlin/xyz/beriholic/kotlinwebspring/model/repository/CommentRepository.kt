package xyz.beriholic.kotlinwebspring.model.repository

import cn.hutool.core.util.IdUtil
import org.babyfish.jimmer.sql.fetcher.Fetcher
import org.babyfish.jimmer.sql.kt.KSqlClient
import org.springframework.stereotype.Repository
import xyz.beriholic.kotlinwebspring.model.entity.Comment

@Repository
class CommentRepository(private val sql: KSqlClient) {
    fun findComments(
        fetcher: Fetcher<Comment>,
        size: Int,
        offset: Long,
    ): List<Comment> {
        return sql.createQuery(Comment::class) {
            select(table.fetch(fetcher))
        }.limit(size, offset).execute()
    }

    fun newComment(
        uid: Long,
        username: String,
        content: String,
    ) {
        sql.save(
            Comment {
                this.id = IdUtil.getSnowflakeNextId()
                this.uid = uid
                this.username = username
                this.content = content
            }
        )
    }
}