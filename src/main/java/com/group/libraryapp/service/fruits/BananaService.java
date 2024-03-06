package com.group.libraryapp.service.fruits;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("main")
public class BananaService implements FruitsService{
}
