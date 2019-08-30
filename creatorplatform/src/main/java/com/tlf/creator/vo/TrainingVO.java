package com.tlf.creator.vo;

import com.tlf.creator.dto.ExamMode;
import com.tlf.creator.dto.PracticeMode;
import com.tlf.creator.dto.TeachMode;

import java.io.Serializable;

public class TrainingVO implements Serializable {

    private String id;

    private String name;

    private TeachMode teachMode;

    private PracticeMode practiceMode;

    private ExamMode examMode;

    public TrainingVO() {
    }

    public TrainingVO(String id, String name, TeachMode teachMode, PracticeMode practiceMode, ExamMode examMode) {
        this.id = id;
        this.name = name;
        this.teachMode = teachMode;
        this.practiceMode = practiceMode;
        this.examMode = examMode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TeachMode getTeachMode() {
        return teachMode;
    }

    public void setTeachMode(TeachMode teachMode) {
        this.teachMode = teachMode;
    }

    public PracticeMode getPracticeMode() {
        return practiceMode;
    }

    public void setPracticeMode(PracticeMode practiceMode) {
        this.practiceMode = practiceMode;
    }

    public ExamMode getExamMode() {
        return examMode;
    }

    public void setExamMode(ExamMode examMode) {
        this.examMode = examMode;
    }
}
