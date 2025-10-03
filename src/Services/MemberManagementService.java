package Services;

import Models.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberManagementService {
    private final List<Member> memberList = new ArrayList<>();
    private static MemberManagementService instance;
    private MemberManagementService() {}
    public synchronized static MemberManagementService getInstance() {
        if (instance == null) {
            instance = new MemberManagementService();
        }
        return instance;
    }
    private boolean memberExists(String memberName) {
        for (Member member : memberList) {
            if (member.getMemberName().equals(memberName)) return true;
        }
        return false;
    }
    public void addMember(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("Member is null");
        }
        if (memberExists(member.getMemberName())) {
            throw new IllegalArgumentException("A member with the name '" + member.getMemberName() + "' already exists.");
        }
        memberList.add(member);
    }
    public void removeMember(Member member) {
        memberList.remove(member);
    }
    public List<Member> getMemberList() {
        return memberList;
    }
}
