package com.devlog.admin.service.content.dto;

import com.devlog.admin.service.tags.dto.TagInfoDto;
import com.devlog.core.common.constants.CommonConstants;
import com.devlog.core.entity.content.Content;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class ContentResDto {

    @Schema(description = "게시물 번호")
    private Long ctntNo;

    @Schema(description = "게시물 제목")
    @Size(max = CommonConstants.CONTENT_TITLE_SIZE, message = "content title length is too long!!")
    private String title;

    @Schema(description = "게시물 부제목")
    @Size(max = CommonConstants.CONTENT_SUBTITLE_SIZE, message = "content title length is too long!!")
    private String subTitle;

    @Schema(description = "게시물 내용")
    private String body;

    @Schema(description = "게시물 태그 목록")
    private List<TagInfoDto> tags;

    @Schema(description = "게시물 경로")
    private String path;

    @Schema(description = "게시물 이름")
    private String name;

    @Schema(description = "게시물 파일 확장자")
    private String ext;

    @Schema(description = "게시물 생성자", defaultValue = CommonConstants.ADMIN_NAME)
    private String inpUser;

    @Schema(description = "게시물 생성일시")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CommonConstants.DEFAULT_DATETIME_FORMAT, timezone = "Asia/Seoul")
    private LocalDateTime inpDttm;

    @Schema(description = "게시물 수정일시")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CommonConstants.DEFAULT_DATETIME_FORMAT, timezone = "Asia/Seoul")
    private LocalDateTime updDttm;

    public static ContentResDto of(Content content) {
        return ContentResDto.builder()
                .ctntNo(content.getCtntNo())
                .title(content.getCtntTitle())
                .body(content.getContentDetail().getCtntBody())
                .tags(TagInfoDto.toTagInfoList(content.getContentTags()))
                .path(content.getContentDetail().getCtntPath())
                .name(content.getContentDetail().getCtntName())
                .ext(content.getContentDetail().getCtntExt())
                .inpUser(content.getInpUser())
                .inpDttm(content.getInpDttm())
                .updDttm(content.getUpdDttm())
                .build();
    }

}