package com.tensquare.split.dao;

import com.tensquare.split.pojo.Spit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpitDao extends MongoRepository<Spit,String> {

}
