package com.eatandplay.academicmanagementsystem.service;

import com.eatandplay.academicmanagementsystem.model.SelectRelation;
import com.eatandplay.academicmanagementsystem.params.resp.SelectDto;
import com.eatandplay.academicmanagementsystem.repository.SelectMapper;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class SelectService {

  private final SelectMapper selectMapper;

  public SelectService(SelectMapper selectMapper) {
    this.selectMapper = selectMapper;
  }

  /**
   * 选课
   *
   * @param selectRelation select
   * @return 执行结果
   */
  public boolean select(SelectRelation selectRelation) {
    return selectMapper.save(selectRelation);
  }

  /**
   * 查询
   *
   * @param studentId id
   * @param courseId  id
   * @return course
   */
  public Optional<SelectDto> selectInfo(int studentId, int courseId) {
    return selectMapper.findById(studentId, courseId);
  }

  /**
   * 分页查询
   *
   * @param pageNum pageNum
   * @param size    size
   * @return course
   */
  public List<SelectDto> list(int pageNum, int size) {
    return selectMapper.findAll(size, pageNum == 0 ? pageNum : size * pageNum);
  }

  /**
   * @return count
   */
  public int count() {
    return selectMapper.count();
  }
}
