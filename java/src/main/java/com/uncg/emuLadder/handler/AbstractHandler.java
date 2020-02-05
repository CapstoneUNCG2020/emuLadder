package com.uncg.emuLadder.handler;

import com.uncg.emuLadder.sanitizer.ISanitizer;
import com.uncg.emuLadder.service.IService;

public abstract class AbstractHandler<T1, T2> {
    private final ISanitizer<T1> sanitizer;
    private final IService<T1, T2> service;

    public T2 handle(T1 requestData) {
        requestData = sanitizer.sanitize(requestData);

        return service.service(requestData);
    }

    public AbstractHandler(IService<T1, T2> service, ISanitizer<T1> sanitizer) {
        this.service = service;
        this.sanitizer = sanitizer;
    }
}
