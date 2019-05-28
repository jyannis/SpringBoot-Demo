package undestiny.springbootswagger2.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel("学生实体")
public class Student {

    @ApiModelProperty("学号（唯一识别码）")
    @NotNull
    private Integer id;

    @ApiModelProperty(value="姓名",name="name",example="Peter")
    private String name;

    @ApiModelProperty("年级")
    private Integer grade;

    public Student() {
    }

    public Student(Integer id, String name, Integer grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
