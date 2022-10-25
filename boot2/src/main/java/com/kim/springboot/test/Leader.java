package com.kim.springboot.test;

public class Leader {
	private String name;
	private Member member;
	public Leader() {
		
	}
	public Leader(String name, Member member) {
		this.name=name;
		this.member=member;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public void hello() {
		member.hello(name+": 안녕하세요!");
	}
}
