import type {Executor} from '../';
import type {
    None, 
    Results, 
    UserInfo, 
    UserLoginInput, 
    UserRegisterInput
} from '../model/static/';

export class UserController {
    
    constructor(private executor: Executor) {}
    
    readonly isLogin: () => Promise<
        Results<boolean>
    > = async() => {
        let _uri = '/user/alive';
        return (await this.executor({uri: _uri, method: 'GET'})) as Promise<Results<boolean>>;
    }
    
    readonly logOut: () => Promise<
        Results<None>
    > = async() => {
        let _uri = '/user/logout';
        return (await this.executor({uri: _uri, method: 'POST'})) as Promise<Results<None>>;
    }
    
    readonly userInfo: () => Promise<
        Results<UserInfo>
    > = async() => {
        let _uri = '/user/info';
        return (await this.executor({uri: _uri, method: 'GET'})) as Promise<Results<UserInfo>>;
    }
    
    readonly userLogin: (options: UserControllerOptions['userLogin']) => Promise<
        Results<number>
    > = async(options) => {
        let _uri = '/user/login';
        return (await this.executor({uri: _uri, method: 'POST', body: options.body})) as Promise<Results<number>>;
    }
    
    readonly userRegister: (options: UserControllerOptions['userRegister']) => Promise<
        Results<None>
    > = async(options) => {
        let _uri = '/user/register';
        return (await this.executor({uri: _uri, method: 'POST', body: options.body})) as Promise<Results<None>>;
    }
}

export type UserControllerOptions = {
    'userRegister': {
        readonly body: UserRegisterInput
    }, 
    'userLogin': {
        readonly body: UserLoginInput
    }, 
    'isLogin': {}, 
    'logOut': {}, 
    'userInfo': {}
}
