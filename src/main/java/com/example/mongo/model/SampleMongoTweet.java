package com.example.mongo.model;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class SampleMongoTweet {
	
	//user details
	private String username;
	private String userhandle;
	private String profilepic;

	//tweet details
	private String tweetContent;
	private List hashtag;
	private List mentions;
	private int numberOfRetweets;
	private int numberOfLikes;
	
	private Date dateOftweet;

}
