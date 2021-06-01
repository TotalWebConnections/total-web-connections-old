(ns nitor-fitness-site.blog.post-list
  (:require [nitor-fitness-site.blog.posts.ten-minute-cardio-warmup :as cardio-warmup]
            [nitor-fitness-site.blog.posts.dead-bugs :as dead-bugs]
            [nitor-fitness-site.blog.posts.importance-of-rest-days :as rest-days]
            [nitor-fitness-site.blog.posts.single-leg-squat :as single-leg-squat]
            [nitor-fitness-site.blog.posts.best-equipment-for-a-home-gym :as best-equipment-home-gym]
            [nitor-fitness-site.components.Blog-card :refer [Blog-card]]))

(def Posts
  {:best-equipment-for-a-home-gym best-equipment-home-gym/post-content
   :single-leg-squat single-leg-squat/post-content
   :10-minute-cardio-warmup cardio-warmup/post-content
   :dead-bugs dead-bugs/post-content
   :importance-of-rest-days rest-days/post-content})



(defn get-post-by-id [id]
  (if id
    ((keyword id) Posts)
    false))

(defn generate-all-posts []
  (for [post Posts]
    (Blog-card post)))

(defn get-n-posts [n]
  (let [post-sub (take n Posts)]
    (for [post post-sub]
      (Blog-card post))))
