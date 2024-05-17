package Persistence;

import Entities.Audio;

import java.util.ArrayList;
import java.util.List;

public class AudioDAO extends DAO<Audio>{

    public AudioDAO() {

    }

    @Override
    public void save(Audio audio) throws Exception {
        try {
            if (audio == null) {
                throw new Exception("Audio can'audio be null");
            }
            String sql = "INSERT INTO audios (idAudio, author, isAvailable, Duration) "
                    + "VALUES ( '" + audio.getId()+ "' , '" + audio.getAuthor()
                    + "' ,'" + (audio.isAvaliable()?1:0) + "','" + audio.getDuration() + "');";
            System.out.println(sql);
            insertModifyDelete(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectDB();
        }

    }

    @Override
    public void delete(Audio audio) throws Exception {
        try {
            if (audio == null) {
                throw new Exception("audio  can't be null");
            }
            String sql = "DELETE FROM audios WHERE idAudio = '" + audio.getId() +"'";
            System.out.println(sql);
            insertModifyDelete(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectDB();
        }
    }

    @Override
    public void update(Audio audio, String lastId) throws Exception {
        try {
            if (audio == null) {
                throw new Exception("Audio can't be null");
            }

            String sql = "UPDATE audios SET " +
                    "idAudio ='" + audio.getId() +"', author ='" + audio.getAuthor() + "', duration = " + audio.getDuration() +
                    " WHERE idAudio = '" + lastId +"';";
            System.out.println(sql);
            insertModifyDelete(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectDB();
        }
    }

    @Override
    public Audio getById(String id) throws Exception {
        Audio audio = new Audio();
        try {
            if (id == null) {
                throw new Exception("ID can't be null");
            }
            String sql = "SELECT * FROM audios WHERE idAudio = '" + id +"'";
            consultDB(sql);
            while (resultSet.next()) {
                audio.setId(resultSet.getString(2));
                audio.setAuthor(resultSet.getString(3));
                audio.setAvaliable(resultSet.getInt(4) == 1);
                audio.setDuration(resultSet.getInt(5));
            }
            return audio;
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            disconnectDB();
        }
        return null;
    }

    @Override
    public List<Audio> getList() throws Exception {
        ArrayList<Audio> audios= new ArrayList<>();
        try {
            String sql = "SELECT * FROM audios";
            consultDB(sql);

            while (resultSet.next()) {
                Audio audio = new Audio();
                audio.setId(resultSet.getString(2));
                audio.setAuthor(resultSet.getString(3));
                audio.setAvaliable(resultSet.getInt(4) == 1);
                audio.setDuration(resultSet.getInt(5));
                audios.add(audio);
            }
            return audios;
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectDB();
        }
    }

    public void updateAudioIsAvailable(Audio audio, String id) throws Exception {
        try {
            if (audio == null) {
                throw new Exception("Audio can't be null");
            }
            int isAvailable = (audio.isAvaliable()?1:0);
            String sql = "UPDATE audios SET " +
                    "isAvailable = " + isAvailable +
                    " WHERE idAudio = '" + id +"';";
            System.out.println(sql);
            insertModifyDelete(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectDB();
        }
    }



}
