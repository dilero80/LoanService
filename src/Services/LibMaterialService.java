package Services;

import Entities.Audio;
import Entities.LibMaterial;
import Entities.Text;
import Entities.Video;
import Enums.typeOfLibMaterial;
import Persistence.AudioDAO;
import Persistence.TextDAO;
import Persistence.VideoDAO;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibMaterialService {
    List<Text> texts;
    List<Audio> audios;
    List<Video> videos;
    Scanner read = new Scanner(System.in, StandardCharsets.ISO_8859_1).useDelimiter("\n");
    TextDAO textDao = new TextDAO();
    AudioDAO audioDao = new AudioDAO();
    VideoDAO videoDao = new VideoDAO();



    public LibMaterialService() throws Exception {
        texts = textDao.getList();
        audios = audioDao.getList();
        videos = videoDao.getList();
    }

    public LibMaterial createLibMaterial(int typeOfLib) throws Exception {
        String id;
        String author;
        System.out.println("Insert Id of " + typeOfLibMaterial.values()[typeOfLib - 1]);
        id = read.next();
        System.out.println(("Insert Author of " + typeOfLibMaterial.values()[typeOfLib - 1]));
        author = read.next();
        return switch (typeOfLib) {
            case 1 -> {
                System.out.println("Insert Number of pages");
                texts.add(new Text(id, true, author, read.nextInt()));
                textDao.save(texts.getLast());
                yield texts.getLast();
            }
            case 2 -> {
                System.out.println("Insert Duration in minutes");
                audios.add(new Audio(id, true, author, read.nextInt()));
                audioDao.save(audios.getLast());
                yield audios.getLast();
            }
            case 3 -> {
                System.out.println("Insert Duration in minutes");
                videos.add(new Video(id, true, author, read.nextInt()));
                videoDao.save(videos.getLast());
                yield videos.getLast();

            }
            default -> null;
        };

    }

    public LibMaterial updateLibMaterial(int typeOfLib) {

        String id;
        String author;
        String newId;
        System.out.println("Insert Id of " + typeOfLibMaterial.values()[typeOfLib - 1] + " to update");
        id = read.next();
        System.out.println("Insert New Id of " + typeOfLibMaterial.values()[typeOfLib - 1]);
        newId = read.next();
        System.out.println(("Insert new Author of " + typeOfLibMaterial.values()[typeOfLib - 1]));
        author = read.next();
        return switch (typeOfLib) {
            case 1 -> {
                try {
                    Text libMaterialtoUpdate = (Text) GetLibByID(typeOfLib, id);
                    int posToUpdate = texts.indexOf(libMaterialtoUpdate);
                    libMaterialtoUpdate.setAuthor(author);
                    libMaterialtoUpdate.setId(newId);
                    System.out.println("Insert Number of pages");
                    libMaterialtoUpdate.setNumPages(read.nextInt());
                    texts.set(posToUpdate, libMaterialtoUpdate);
                    textDao.update(texts.get(posToUpdate), id);
                    yield texts.get(posToUpdate);
                } catch (Exception e) {
                    System.out.println("Can update Text");
                    yield null;
                }
            }
            case 2 -> {
                try {
                    Audio libMaterialtoUpdate = (Audio) GetLibByID(typeOfLib, id);
                    int posToUpdate = audios.indexOf(libMaterialtoUpdate);
                    libMaterialtoUpdate.setAuthor(author);
                    libMaterialtoUpdate.setId(newId);
                    System.out.println("Insert Duration in minutes");
                    libMaterialtoUpdate.setDuration(read.nextInt());
                    audios.set(posToUpdate, libMaterialtoUpdate);
                    audioDao.update(audios.get(posToUpdate), id);
                    yield audios.get(posToUpdate);
                } catch (Exception e) {
                    System.out.println(e.toString());
                    System.out.println("Can update Audio");
                    yield null;
                }
            }
            case 3 -> {
                try{
                    Video libMaterialtoUpdate = (Video) GetLibByID(typeOfLib,id);
                    int posToUpdate = videos.indexOf(libMaterialtoUpdate);
                    libMaterialtoUpdate.setAuthor(author);
                    libMaterialtoUpdate.setId(newId);
                    System.out.println("Insert Duration in minutes");
                    libMaterialtoUpdate.setDuration(read.nextInt());
                    videos.set(posToUpdate, libMaterialtoUpdate);
                    videoDao.update(videos.get(posToUpdate), id);
                    yield videos.get(posToUpdate);
                } catch (Exception e) {
                    System.out.println(e.toString());
                    System.out.println("Can Update Video");
                    yield null;
                }
            }
            default -> null;
        };

    }

    public LibMaterial updateLibMaterialIsAvaliable(int typeOfLib, LibMaterial libMaterialtoUpdate) {

        return switch (typeOfLib) {
            case 1 -> {
                try {
                    int posToUpdate = texts.indexOf(libMaterialtoUpdate);
                    System.out.println(libMaterialtoUpdate);
                    libMaterialtoUpdate.setAvaliable(!libMaterialtoUpdate.isAvaliable());
                    texts.set(posToUpdate, (Text) libMaterialtoUpdate);
                    textDao.updateTextIsAvaliable(texts.get(posToUpdate), libMaterialtoUpdate.getId());
                    yield texts.get(posToUpdate);
                } catch (Exception e) {
                    System.out.println("Can update Text");
                    yield null;
                }
            }
            case 2 -> {
                try {
                    int posToUpdate = audios.indexOf(libMaterialtoUpdate);
                    libMaterialtoUpdate.setAvaliable(!libMaterialtoUpdate.isAvaliable());
                    audios.set(posToUpdate, (Audio) libMaterialtoUpdate);
                    audioDao.updateAudioIsAvailable(audios.get(posToUpdate), libMaterialtoUpdate.getId());
                    yield audios.get(posToUpdate);
                } catch (Exception e) {
                    System.out.println(e.toString());
                    System.out.println("Can update Audio");
                    yield null;
                }
            }
            case 3 -> {
                try{
                    int posToUpdate = videos.indexOf(libMaterialtoUpdate);
                    libMaterialtoUpdate.setAvaliable(!libMaterialtoUpdate.isAvaliable());
                    videos.set(posToUpdate, (Video) libMaterialtoUpdate);
                    videoDao.updateVideoIsAvailable(videos.get(posToUpdate), libMaterialtoUpdate.getId());
                    yield videos.get(posToUpdate);
                } catch (Exception e) {
                    System.out.println(e.toString());
                    System.out.println("Can Update Video");
                    yield null;
                }
            }
            default -> null;
        };

    }

    public LibMaterial deleteLibMaterial(int typeOfLib) {

        String id;
        System.out.println("Insert Id of " + typeOfLibMaterial.values()[typeOfLib - 1] + " to delete");
        id = read.next();
        return switch (typeOfLib) {
            case 1 -> {
                try {
                    Text libMaterialDelete = (Text) GetLibByID(typeOfLib, id);
                    texts.remove(libMaterialDelete);
                    textDao.delete(libMaterialDelete);
                    yield libMaterialDelete;
                } catch (Exception e) {
                    System.out.println("Can delete Text");
                    yield null;
                }
            }
            case 2 -> {
                try {
                    Audio libMaterialDelete = (Audio) GetLibByID(typeOfLib, id);
                    audios.remove(libMaterialDelete);
                    audioDao.delete(libMaterialDelete);
                    yield libMaterialDelete;
                } catch (Exception e) {
                    System.out.println("Can not delete Audio");
                    yield null;
                }
            }
            case 3 -> {
                try{
                    Video libMaterialDelete = (Video) GetLibByID(typeOfLib,id);
                    videos.remove(libMaterialDelete);
                    videoDao.delete(libMaterialDelete);
                    yield libMaterialDelete;
                } catch (Exception e) {
                    System.out.println("Can not Delete Video");
                    yield null;
                }
            }
            default -> null;
        };

    }

    public void getLibList(int type) {
        switch (type) {
            case 1:
                texts.forEach(System.out::println);
                break;
            case 2:
                audios.forEach(System.out::println);
                break;
            case 3:
                videos.forEach(System.out::println);
                break;
            default:
                System.out.println("No List to show");
                break;
        }
    }

    public LibMaterial GetLibByID(int type, String id) {
        return switch (type) {
            case 1 -> {
                try {
                    yield textDao.getById(id);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            case 2 -> {
                try{
                    yield audioDao.getById(id);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            case 3 -> {
                try {
                    yield videoDao.getById(id);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            default -> null;

        };
    }
}