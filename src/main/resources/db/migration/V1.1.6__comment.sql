-- 변경 사항 --
-- 1. 좋아요랑 댓글 기능은 giscus를 사용하기로 했기 때문에 좋아요, 댓글 테이블 삭제

ALTER TABLE `like` DROP FOREIGN KEY fk_like_comment_id;

DROP TABLE comment;