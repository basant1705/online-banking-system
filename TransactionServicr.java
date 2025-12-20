@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {
    @InjectMocks
    private TransactionService transactionService;

    @Mock
    private AccountDAO accountDAO;

    @Test
    void testTransferFunds() {
        Account sender = new Account(1, "John", 1000.00);
        Account receiver = new Account(2, "Jane", 500.00);

        when(accountDAO.findAccountById(1)).thenReturn(sender);
        when(accountDAO.findAccountById(2)).thenReturn(receiver);

        transactionService.transferFunds(1, 2, 200.00);

        assertEquals(800.00, sender.getBalance());
        assertEquals(700.00, receiver.getBalance());
    }
}
