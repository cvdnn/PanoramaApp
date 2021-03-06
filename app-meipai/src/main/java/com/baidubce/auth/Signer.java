package com.baidubce.auth;

import com.baidubce.internal.InternalRequest;

public interface Signer {
    void sign(InternalRequest internalRequest, BceCredentials bceCredentials);

    void sign(InternalRequest internalRequest, BceCredentials bceCredentials, SignOptions signOptions);
}
