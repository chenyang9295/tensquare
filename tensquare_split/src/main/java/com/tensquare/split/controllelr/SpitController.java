package com.tensquare.split.controllelr;

import com.tensquare.split.pojo.Spit;
import com.tensquare.split.service.SpitService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/spit")
public class SpitController {

    @Autowired
    private SpitService spitService;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping
    public Result findAll()
    {
        return new Result(true, StatusCode.OK,"查询成功",spitService.findAll());
    }

    @GetMapping(value = "/{spitId}")
    public Result findById(@PathVariable String spitId)
    {
        return new Result(true,StatusCode.OK,"查询成功",spitService.findById(spitId));
    }

    @PostMapping()
    public Result save(@RequestBody Spit spit)
    {
        spitService.save(spit);
        return new Result(true,StatusCode.OK,"插入成功");
    }

    @PutMapping(value = "/{spitId}")
    public Result update(@PathVariable  String spitId,@RequestBody Spit spit)
    {
        spit.set_id(spitId);
        spitService.update(spit);
        return new Result(true,StatusCode.OK,"更新成功");
    }

    @GetMapping(value = "/comment/{parentid}/{page}/{size}")
    public Result findByParentId(String parentId,int page,int size)
    {
        Page<Spit> pageData = spitService.findByParentId(parentId, page, size);
        return new Result(true,StatusCode.OK,"查找成功",new PageResult<>(pageData.getTotalElements(),pageData.getContent()));
    }

    @PutMapping(value = "/thumbup/{spitId}")
    public Result thumbup(@PathVariable String spitId) {
        String id = "123";
        if (redisTemplate.opsForValue().get("thumbup_" + id) != null) {
            return new Result(true, StatusCode.EPERROR, "不能重复点赞");
        } else {
            spitService.thumbup(spitId);
            redisTemplate.opsForValue().set("thumbup_" + id,1);
            return new Result(true, StatusCode.OK, "吐槽成功");
        }
    }
}
