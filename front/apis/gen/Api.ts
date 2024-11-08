import type {Executor} from './';
import {CommentController, UserController} from './services/';

export class Api {
    
    readonly commentController: CommentController
    
    readonly userController: UserController
    
    constructor(executor: Executor) {
        this.commentController = new CommentController(executor);
        this.userController = new UserController(executor);
    }
}