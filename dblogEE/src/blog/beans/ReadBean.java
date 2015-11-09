package blog.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import blog.BlogController;
import blog.Topic;

/* トピックの投稿、購読を行う */
@Named
@RequestScoped
public class ReadBean {
	private String title;
	private String content;
	
	/**
	 * トピックをDBに登録する
	 * @return "read.xhtml"  ※固定
	 */
	public String post() {
		Topic topic = new Topic();
		topic.setTitle(title);
		title = "";
		topic.setContent(content);
		content = "";
		BlogController ctrl = BlogController.getInstance();
		ctrl.postTopic(topic);
		
		return "read.xhtml";
	}
	
	/**
	 * 全てのトピックを取得する
	 * @return HTML形式の全トピック情報
	 */
	public String topics() {
		BlogController ctrl = BlogController.getInstance();
		List<Topic> topics = ctrl.getTopics();
		StringBuilder sb = new StringBuilder();
		for (int i=topics.size() - 1; i>=0; i--) {
			Topic topic = topics.get(i);
			sb.append("<hr>");
			sb.append("タイトル：" + topic.getTitle());
			sb.append(" (" + topic.getPostDate() + ")");
			sb.append("<pre>" + topic.getContent() + "</pre>");
		}
		return sb.toString();
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
}
