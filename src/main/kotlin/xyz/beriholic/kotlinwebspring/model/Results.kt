package xyz.beriholic.kotlinwebspring.model

data class Results<T>(
    val code: Short,
    val msg: String,
    val data: T?,
) {
    companion object {
        fun <T> ok(
            code: Short = 200,
            msg: String = "success",
            data: T? = null,
        ): Results<T> {
            return Results(code, msg, data)
        }

        fun <T> fail(
            code: Short = 0,
            msg: String = "failed",
            data: T? = null,
        ): Results<T> {
            return Results(code, msg, data)
        }
    }
}