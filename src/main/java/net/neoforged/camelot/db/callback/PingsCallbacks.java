package net.neoforged.camelot.db.callback;

import net.neoforged.camelot.db.api.ExecutionCallback;
import net.neoforged.camelot.db.transactionals.PingsDAO;
import net.neoforged.camelot.listener.CustomPingListener;

public class PingsCallbacks {
    @ExecutionCallback(methodName = "insert")
    public static void onInsert(PingsDAO dao, long guild, long user, String regex, String message) {
        CustomPingListener.requestRefresh();
    }

    @ExecutionCallback(methodName = "deletePing")
    public static void onDelete(PingsDAO dao, int id) {
        CustomPingListener.requestRefresh();
    }

    @ExecutionCallback(methodName = "deletePingsOf")
    public static void onDeleteAll(PingsDAO dao, long user, long guild) {
        CustomPingListener.requestRefresh();
    }
}
