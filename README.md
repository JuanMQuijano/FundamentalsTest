# Music Management API

---

## Description

This project is a RESTful API built with **Spring Boot**, **Spring JPA**, and **Lombok**, designed to manage musical genres, artists, albums, songs, and playlists. It uses **H2** as an in-memory database for testing and development purposes and provides seamless integration with tools like **Postman** for API testing.

---

## Project Structure

### 1. Genre
- **Attributes**:
    - `name`: The name of the genre.
    - `description`: A description of the genre.
    - `artists`: A list of artists associated with the genre.
- **Relationship**:
    - **One-to-Many** with Artist: A genre can include many artists.

- **Endpoints**:
    - `POST /api/v1/genres`: Create a new genre.
    - `GET /api/v1/genres`: Retrieve all genres.
    - `GET /api/v1/genres/{id}`: Retrieve a genre by its ID.
    - `PUT /api/v1/genres/{id}`: Update an existing genre.
    - `DELETE /api/v1/genres/{id}`: Delete a genre by its ID.

### 2. Artist
- **Attributes**:
    - `name`: The name of the artist.
    - `genre`: The genre the artist belongs to.
    - `albums`: A list of albums created by the artist.
- **Relationship**:
    - **Many-to-One** with Genre: An artist belongs to one genre.
    - **One-to-Many** with Album: An artist can have multiple albums.

- **Endpoints**:
    - `POST /api/v1/artists`: Create a new artist.
    - `GET /api/v1/artists`: Retrieve all artists.
    - `GET /api/v1/artists/{id}`: Retrieve an artist by its ID.
    - `PUT /api/v1/artists/{id}`: Update an existing artist.
    - `DELETE /api/v1/artists/{id}`: Delete an artist by its ID.

### 3. Album
- **Attributes**:
    - `name`: The name of the album.
    - `releaseDate`: The release date of the album.
    - `artist`: The artist who owns the album.
    - `songs`: A list of songs included in the album.
- **Relationship**:
    - **Many-to-One** with Artist: An album belongs to one artist.
    - **One-to-Many** with Song: An album can include multiple songs.

- **Endpoints**:
    - `POST /api/v1/albums`: Create a new album.
    - `GET /api/v1/albums`: Retrieve all albums.
    - `GET /api/v1/albums/{id}`: Retrieve an album by its ID.
    - `PUT /api/v1/albums/{id}`: Update an existing album.
    - `DELETE /api/v1/albums/{id}`: Delete an album by its ID.

### 4. Song
- **Attributes**:
    - `name`: The name of the song.
    - `duration`: The duration of the song.
    - `album`: The album the song belongs to.
    - `playlists`: The playlists that include the song.
- **Relationship**:
    - **Many-to-One** with Album: A song belongs to one album.
    - **Many-to-Many** with Playlist: A song can be part of multiple playlists.

- **Endpoints**:
    - `POST /api/v1/songs`: Create a new song.
    - `GET /api/v1/songs`: Retrieve all songs.
    - `GET /api/v1/songs/{id}`: Retrieve a song by its ID.
    - `PUT /api/v1/songs/{id}`: Update an existing song.
    - `DELETE /api/v1/songs/{id}`: Delete a song by its ID.

### 5. Playlist
- **Attributes**:
    - `name`: The name of the playlist.
    - `description`: A description of the playlist.
    - `songs`: A list of songs in the playlist.
- **Relationship**:
    - **Many-to-Many** with Song: A playlist can include many songs, and a song can be part of many playlists.

- **Endpoints**:
    - `POST /api/v1/playlists`: Create a new playlist.
    - `GET /api/v1/playlists`: Retrieve all playlists.
    - `GET /api/v1/playlists/{id}`: Retrieve a playlist by its ID.
    - `PUT /api/v1/playlists/{id}`: Update an existing playlist.
    - `DELETE /api/v1/playlists/{id}`: Delete a playlist by its ID.

---

## Technologies Used

- **Backend Framework**: Spring Boot
- **ORM**: Spring JPA
- **Dependency Management**: Lombok, MapStruct
- **Database**: H2 (in-memory for development and testing)
- **API Testing**: Postman

---

## Getting Started

### Prerequisites
- Java 17+
- Maven

### Run

- **Access the H2 Console:**

    URL: http://localhost:8090/h2-console
    Default credentials:
        JDBC URL: jdbc:h2:mem:fundamentals
        Username: root
        Password: root

- **Test the API:**

    Use the provided Postman collection (postman_collection.json) to test the endpoints.
    Base URL: http://localhost:8090/api/v1