package com.devlog.core.entity.content;

import com.devlog.core.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Table(name = "contents_mst")
public class ContentEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CTNT_NO", nullable = false)
    private Long ctntNo;

    @Column(name = "CTNT_TITLE", nullable = false)
    private String ctntTitle;

    @Column(name = "CTNT_SUBTITLE", nullable = false)
    private String ctntSubTitle;

    @Column(name = "INP_USER", nullable = false)
    private String inpUser;

    @OneToOne(mappedBy = "content", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ContentDtlEntity contentDetail;

    @OneToMany(mappedBy = "contents", cascade = CascadeType.ALL)
    @OrderBy("sort asc")
    List<ContentTagsEntity> contentTags = new ArrayList<>();

}