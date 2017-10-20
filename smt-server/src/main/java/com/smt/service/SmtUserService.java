package com.smt.service;

import com.smt.dto.SmtUserDto;
import java.util.List;

public interface SmtUserService {

  SmtUserDto create(SmtUserDto userDto);

  List<SmtUserDto> list();
}