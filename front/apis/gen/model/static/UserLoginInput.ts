/**
 * <p>
 *  tb_user
 * 
 * </p>
 */
export interface UserLoginInput {
    /**
     * username
     */
    readonly username?: string | undefined;
    /**
     * password
     */
    readonly password: string;
}
