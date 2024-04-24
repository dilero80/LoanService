package Persistence;

import Entities.Audio;

public class AudioDAO extends DAO{

    public AudioDAO() {

    }

    public void saveAudio(Audio audio) throws Exception {
        try {
            if (audio == null) {
                throw new Exception("Audio can't be null");
            }
            String sql = "INSERT INTO audios (idAudio, author, isAvailable, Duration) "
                    + "VALUES ( " + audio.getId()+ " , '" + audio.getAuthor()
                    + "' ,'" + audio.isAvaliable() + "','" + audio.getDuration() + "');";
            System.out.println(sql);
            insertModifyDelete(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectDB();
        }
    }

    public void deleteAudio(Audio audio) throws Exception {
        try {
            if (audio == null) {
                throw new Exception("audio  can't be null");
            }
            String sql = "DELETE FROM audios WHERE userId = " + audio.getId();
            System.out.println(sql);
            insertModifyDelete(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectDB();
        }
    }





}
