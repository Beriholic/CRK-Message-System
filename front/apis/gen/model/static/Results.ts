export interface Results<T> {
    readonly code: number;
    readonly msg: string;
    readonly data?: T | undefined;
}
