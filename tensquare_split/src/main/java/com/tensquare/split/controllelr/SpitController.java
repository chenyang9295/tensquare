package com.tensquare.split.controllelr;

import com.tensquare.split.pojo.Spit;
import com.tensquare.split.service.SpitService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/spit")
public class SpitController {

    @Autowired
    private SpitService spitService;

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
}
