package it.sevenbits.tasks.two;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;

public class UserManagerTest {
    public UserManager userManager;
    public ICollection iCollection;
    @Captor
    ArgumentCaptor<User> userCaptor;

    @Before
    public void setUp() {
        iCollection = mock(ICollection.class);
        userManager = new UserManager(iCollection);
    }


    @Test
    public void testGetUserByIndex() throws UserManagerException, IOException {
        when(iCollection.get(0)).thenReturn(new User("1", "11"));
        when(iCollection.get(1)).thenReturn(new User("2", "22"));

        User user_id_0 = this.userManager.getUserByIndex(0);
        User user_id_1 = this.userManager.getUserByIndex(1);
        User userExpected_ID_0 = new User("1", "11");
        User userExpected_ID_1 = new User("2", "22");
        assertEquals(user_id_0.getName(), userExpected_ID_0.getName());
        assertEquals(user_id_1.getName(), userExpected_ID_1.getName());
        assertEquals(user_id_0.getRole(), userExpected_ID_0.getRole());
        assertEquals(user_id_0.getRole(), userExpected_ID_0.getRole());
        verify(this.iCollection).get(0);
        verify(this.iCollection).get(1);
    }

    @Test(expected = UserManagerException.class)
    public void testGetUserByIndexWithException() throws UserManagerException, IOException {
        when(iCollection.get(42)).thenThrow(new IOException());

        this.userManager.getUserByIndex(42);
    }

    @Test
    public void testCreateDefault() throws UserManagerException, IOException {
        userCaptor = ArgumentCaptor.forClass(User.class);
        this.userManager.createDefault("user_name");
        verify(this.iCollection).add(this.userCaptor.capture());
        assertEquals("user_name", userCaptor.getValue().getName());
        assertEquals("default", userCaptor.getValue().getRole());
    }

    @Test(expected = UserManagerException.class)
    public void testCreateDefaultWithException() throws UserManagerException, IOException {
        doThrow(new IOException()).when(iCollection).add(isA(User.class));
        this.userManager.createDefault("user_name");
    }
}
