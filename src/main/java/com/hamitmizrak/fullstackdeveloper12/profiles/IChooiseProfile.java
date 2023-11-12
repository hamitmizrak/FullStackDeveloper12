package com.hamitmizrak.fullstackdeveloper12.profiles;

import org.springframework.stereotype.Component;
// @Component: IChooiseProfile nesnesi Spring nesnesi olması için
@Component
public interface IChooiseProfile {
    public String message(String name);
}
