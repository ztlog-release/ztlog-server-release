package com.devlog.admin.service.tags.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
public class TagReqDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -4642091134040102457L;

    private Long tagsNo;

    private String tagsName;

}