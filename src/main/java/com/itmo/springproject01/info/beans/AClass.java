package com.itmo.springproject01.info.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component // бин создан и помещён в контекст
public class AClass implements IType {
}