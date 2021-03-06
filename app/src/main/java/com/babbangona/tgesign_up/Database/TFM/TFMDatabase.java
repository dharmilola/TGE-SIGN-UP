package com.babbangona.tgesign_up.Database.TFM;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.babbangona.tgesign_up.Database.TFM.Dao.CheckListTableDao;
import com.babbangona.tgesign_up.Database.TFM.Dao.LastSyncTableDao;
import com.babbangona.tgesign_up.Database.TFM.Dao.MembersDao;
import com.babbangona.tgesign_up.Database.TFM.Dao.OldMembersDao;
import com.babbangona.tgesign_up.Database.TFM.Dao.PictureSyncDao;
import com.babbangona.tgesign_up.Database.TFM.Dao.TFMAppVariablesDao;
import com.babbangona.tgesign_up.Database.TFM.Dao.TFMTemplateTrackerTableDao;
import com.babbangona.tgesign_up.Database.TFM.Dao.TGEDao;
import com.babbangona.tgesign_up.Database.TFM.Dao.prospectiveTGEDao;
import com.babbangona.tgesign_up.Database.TFM.Dao.prospectiveTGLDao;
import com.babbangona.tgesign_up.Database.TFM.Dao.scheduleDao;
import com.babbangona.tgesign_up.Database.TFM.Table.CheckListTable;
import com.babbangona.tgesign_up.Database.TFM.Table.LastSyncTable;
import com.babbangona.tgesign_up.Database.TFM.Table.MembersTable;
import com.babbangona.tgesign_up.Database.TFM.Table.OldMembersTable;
import com.babbangona.tgesign_up.Database.TFM.Table.PictureSync;
import com.babbangona.tgesign_up.Database.TFM.Table.TFMAppVariables;
import com.babbangona.tgesign_up.Database.TFM.Table.TFMTemplateTrackerTable;
import com.babbangona.tgesign_up.Database.TFM.Table.scheduleTable;
import com.babbangona.tgesign_up.Database.TFM.Table.TGE;
import com.babbangona.tgesign_up.Database.TFM.Table.prospectiveTGETable;
import com.babbangona.tgesign_up.Database.TFM.Table.prospectiveTGLTable;


@Database(entities = {MembersTable.class , OldMembersTable.class, TGE.class,
        TFMAppVariables.class, CheckListTable.class, LastSyncTable.class,
        TFMTemplateTrackerTable.class, prospectiveTGETable.class, prospectiveTGLTable.class, scheduleTable.class,
        PictureSync.class},

        version = TFMDBContractClass.TFM_DATABASE_VERSION, exportSchema = false)

public abstract  class TFMDatabase extends RoomDatabase {

    public abstract MembersDao getMembersTable();
    public abstract OldMembersDao getOldMembersTable();
    public abstract TGEDao getTGEDao();
    public abstract prospectiveTGEDao getProspectiveTGEDao();
    public abstract prospectiveTGLDao getProspectiveTGLDao();
    public abstract TFMAppVariablesDao getTFMAppVariablesTable();
    public abstract CheckListTableDao getCheckListTableDao();
    public abstract LastSyncTableDao getLastSyncTableDao();
    public abstract TFMTemplateTrackerTableDao getTFMTemplateTrackerTableDao();
    public abstract scheduleDao getscheduleTable();
    private static TFMDatabase tfmDatabase;
    public abstract PictureSyncDao getPictureSyncDao();

    /**
     * Return instance of database creation
     * */
    public static TFMDatabase getInstance(Context context) {
        if (null == tfmDatabase) {
            tfmDatabase = buildDatabaseInstance(context);
        }
        return tfmDatabase;
    }


    private static TFMDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context,
                TFMDatabase.class,
                TFMDBContractClass.TFM_DATABASE_NAME)
                .allowMainThreadQueries().build();
        //.fallbackToDestructiveMigration()
    }

    public void cleanUp(){
        tfmDatabase = null;
    }
}
