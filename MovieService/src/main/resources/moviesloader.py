# json_file =  open("C:\\Users\\AD36038\\OneDrive - Lumen\\Code\\Training\\Spring\\MovieService\\src\\main\\resources","r")

import json

import requests

import random


import time


import threading

json_file = open("C:\\Users\\AD36038\\Downloads\\csvjson.json",encoding="utf8")

json_content = json_file.read()

movies = json.loads(json_content)

def randomIMDBID()->str:
    return f"tt{random.randint(1000000,9999999)}"

def post_movie(movie):
    time.sleep(0.5)
    r = requests.post('http://localhost:8082',json={"imdbID":randomIMDBID(),
                                                    "imdbRating":movie["IMDB_Rating"],
                                                    "title":movie["Series_Title"],
                                                    "releaseDate":movie["Released_Year"],
                                                    "genre":movie["Genre"],
                                                    "director":movie["Director"],
                                                    "actors":f"{movie['Star1']},{movie['Star2']},{movie['Star3']},{movie['Star4']}",
                                                    "language":"English",
                                                    "plot":movie["Overview"]})
    print(r.text)
    
for movie in movies:
    print(movie['Series_Title'])
    t1 = threading.Thread(target=post_movie,args=[movie])
    t1.start()

# movies = list(movies)

# print(movies[1]['IMDB_Rating'])

# post_movie(movies[1])