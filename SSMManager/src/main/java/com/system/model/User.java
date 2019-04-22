package com.system.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;


/**
 * <p>
 * 
 * </p>
 *
 * @author yx
 * @since 2017-08-16
 */
public class User extends Model<User> {

	@TableField(exist= false)
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
	@TableId(type = IdType.AUTO)
	private Integer Id;
    /**
     * 姓名
     */
	private String name;
    /**
     * 年龄
     */
	private Integer age;


	public Integer getId() {
		return Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	protected Serializable pkVal() {
		return this.Id;
	}

}
