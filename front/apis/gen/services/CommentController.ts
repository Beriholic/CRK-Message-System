import type {Executor} from '../';
import type {CommentDto} from '../model/dto/';
import type {CreateCommentInput, None, Results} from '../model/static/';

export class CommentController {
    
    constructor(private executor: Executor) {}
    
    readonly getComments: (options: CommentControllerOptions['getComments']) => Promise<
        Results<ReadonlyArray<CommentDto['CommentController/BASE_COMMENT']>>
    > = async(options) => {
        let _uri = '/comments';
        let _separator = _uri.indexOf('?') === -1 ? '?' : '&';
        let _value: any = undefined;
        _value = options.size;
        _uri += _separator
        _uri += 'size='
        _uri += encodeURIComponent(_value);
        _separator = '&';
        _value = options.offset;
        _uri += _separator
        _uri += 'offset='
        _uri += encodeURIComponent(_value);
        _separator = '&';
        return (await this.executor({uri: _uri, method: 'GET'})) as Promise<Results<ReadonlyArray<CommentDto['CommentController/BASE_COMMENT']>>>;
    }
    
    readonly newComment: (options: CommentControllerOptions['newComment']) => Promise<
        Results<None>
    > = async(options) => {
        let _uri = '/comment/new';
        return (await this.executor({uri: _uri, method: 'POST', body: options.body})) as Promise<Results<None>>;
    }
}

export type CommentControllerOptions = {
    'getComments': {
        readonly size: number, 
        readonly offset: number
    }, 
    'newComment': {
        readonly body: CreateCommentInput
    }
}
