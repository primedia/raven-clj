(ns raven-clj.interfaces)

(defn- make-http-info [req]
  {:url (str (name (:scheme req))
             "://"
             (:server-name req)
             (if (not= 80 (:server-port req))
               (str ":" (:server-port req)))
             (:uri req))
   :method (:method req)
   :headers (get req :headers {})
   :query_string (get req :query-string "")
   :data (get req :params {})
   :env {:session (get req :session {})}})

(defn http [event-map req]
  (assoc event-map "sentry.interfaces.Http"
         (make-http-info req)))

(defn- make-frame [^StackTraceElement element]
  {:filename (.getFileName element)
   :lineno (.getLineNumber element)
   :function (str (.getClassName element) "." (.getMethodName element))})

(defn- make-stacktrace-info [elements]
  {:frames (reverse (map make-frame elements))})

(defn stacktrace [event-map ^Exception e]
  (assoc event-map "sentry.interfaces.Stacktrace"
         (make-stacktrace-info (.getStackTrace e))))
