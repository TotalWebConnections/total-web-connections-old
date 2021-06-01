(ns total-web-connections.utils.seo)

; defaults for SEO stuff if missing
(def TITLE "Total Web Connections")
(def DESCRIPTION "Full Service Web and Marketing Company Winfield Il")
(def PUBLISHED "null")

(defn set-seo-title [post]
  (set! (.-title js/document)
    (or
      (-> post :header :title)
      TITLE)))

(defn set-meta-desc [post]
  (.setAttribute (.querySelector js/document "meta[name=description]") "content"
    (or
      (-> post :header :meta-desc)
      DESCRIPTION)))

(defn set-published-date [post]
  (.setAttribute (.querySelector js/document "meta[itemprop=datePublished]") "content"
    (or
      (-> post :header :published)
      PUBLISHED)))

