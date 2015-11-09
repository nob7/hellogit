package blog;

import java.util.Date;

public class Topic {
	private int id;			/* 連番 */
	private String title;	/* タイトル */
	private String content;	/* 内容 */
	private Date postDate;	/* 投稿日 */
	
	public String toString() {
		return super.toString()
				+ ",id=" + id
				+ ",title=" + title
				+ ",content=" + content
				+ ",postDate=" + postDate
				;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getPostDate() {
		return postDate;
	}
	
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
}
