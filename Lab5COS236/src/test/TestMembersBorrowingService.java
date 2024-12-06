package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.Member;
import lab5.PaperBook;

public class TestMembersBorrowingService {
    private final BorrowingService service = BorrowingService.getInstance();

    @org.junit.jupiter.api.Test
    public void testMemberServices() {
        Member member1 = new Member("Member 1", service);
        Member member2 = new Member("Member 2", service);

        assertEquals(
                member1.getBorrowingService(),
                member2.getBorrowingService(),
                "Members have two different borrowing services"
        );
    }
}
