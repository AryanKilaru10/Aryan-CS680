package edu.umb.cs680.hw15;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class AlphabeticalComparatorTest {

    Directory root = new Directory("root", 7, LocalDateTime.now(), null);

    Directory Apps = new Directory("Apps", 7, LocalDateTime.now(), root);

    Directory bin = new Directory("Lib", 7, LocalDateTime.now(), root);

    Directory Home = new Directory("Home", 7, LocalDateTime.now(), root);

    Directory pictures = new Directory("Code", 7, LocalDateTime.now(), Home);

    File x = new File("x", 7, LocalDateTime.now(), Apps);

    File y = new File("y", 7, LocalDateTime.now(), bin);

    File a = new File("a", 7, LocalDateTime.now(), pictures);

    File b = new File("b", 7, LocalDateTime.now(), pictures);

    File c = new File("c", 7, LocalDateTime.now(), Home);

    Link d = new Link("d", 7, LocalDateTime.now(), pictures, root);

    Link e = new Link("e", 7, LocalDateTime.now(), x, root);

    @Test
    public void AlphabeticalComparatorTest() {
        LinkedList<FSElement> actual = root.getChildren(new AlphabeticalComparator());
        FSElement[] expected = {d, e};
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void FileAlphabeticalComparatorHome() {
        LinkedList<File> actual = Home.getFiles(new AlphabeticalComparator());
        File[] expected = {c};
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void FileAlphabeticalComparatorpictures() {
        LinkedList<File> actual = pictures.getFiles(new AlphabeticalComparator());
        File[] expected = {a, b};
        assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void DirectoryAlphabeticalComparator() {
        LinkedList<Directory> actual = root.get_sub_directories(new AlphabeticalComparator());
        Directory[] expected = {};
        assertArrayEquals(expected, actual.toArray());

    }

}