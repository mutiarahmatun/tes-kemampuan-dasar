package id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.models.User;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.repositori.UserRepository;

public class FirstRankService extends Service{
    private UserRepository userRepository;

    private static final String TAG = "FirstRankService";
    public class FirstRankServiceImpl extends IFirstRankService.Stub
    {
        @Override
        public String getFirstRank() throws RemoteException
        {
            if (userRepository == null) userRepository = new UserRepository(getApplication());
            User firstRank = userRepository.getFirstRank();
            return String.format("%s %s",firstRank.getName(),firstRank.getScore());
        }
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        return new FirstRankServiceImpl();
    }
}
