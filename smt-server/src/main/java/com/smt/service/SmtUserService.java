package com.smt.service;

import com.smt.dto.SmtUserDto;
import com.smt.exception.SmtException;
import java.util.List;

public interface SmtUserService {

  SmtUserDto create(SmtUserDto userDto) throws SmtException;

  List<SmtUserDto> list();
}