package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LabelService {

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;


    public List<Label> findAll()
    {
        return labelDao.findAll();
    }

    public Label findById(String Id)
    {
        return labelDao.findById(Id).get();
    }

    public void save(Label label)
    {
        label.setId(idWorker.nextId()+"");
        labelDao.save(label);
    }

    public void update(Label label)
    {
        labelDao.save(label);
    }

    public void deleteById(String Id)
    {
        labelDao.deleteById(Id);
    }


    public List<Label> findsearch(Label label) {
        return labelDao.findAll(new Specification<Label>() {
            /**
             * @param root 根对象，where clounmName    其中clounmName靠root.get方法获取
             * @param query 查询条件
             * @param cb   条件封装
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //此处的list是为了后面创建Predicate的大小new的
                List<Predicate> list=new ArrayList<>();
                if (label.getLabelname() != null && !"".equals(label.getLabelname())) {
                    Predicate predicate = cb.like(root.get("labelname").as(String.class), "%"+label.getLabelname()+"%");
                    list.add(predicate);
                }
                if (label.getState()!=null && !"".equals(label.getState()))
                {
                    Predicate predicate = cb.like(root.get("state").as(String.class), label.getState());
                    list.add(predicate);
                }
                Predicate[] predicate=new Predicate[list.size()];
                //转换成数组
                predicate = list.toArray(predicate);
                return cb.and(predicate);
            }
        });
    }

    public Page<Label> pageQuery(Label label, int page, int size) {
        Pageable pageable= PageRequest.of(page-1,size);   //ctrl + H 查看实现类
      return labelDao.findAll(new Specification<Label>() {
          public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
              //此处的list是为了后面创建Predicate的大小new的
              List<Predicate> list=new ArrayList<>();
              if (label.getLabelname() != null && !"".equals(label.getLabelname())) {
                  Predicate predicate = cb.like(root.get("labelname").as(String.class), "%"+label.getLabelname()+"%");
                  list.add(predicate);
              }
              if (label.getState()!=null && !"".equals(label.getState()))
              {
                  Predicate predicate = cb.like(root.get("state").as(String.class), label.getState());
                  list.add(predicate);
              }
              Predicate[] predicate=new Predicate[list.size()];
              //转换成数组
              predicate = list.toArray(predicate);
              return cb.and(predicate);
          }
      },pageable);
}
    }

