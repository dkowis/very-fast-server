package main

import "net/http"

func main(){ 
  bytes := make([]byte, 1024*1024)
         for i:= 0; i < len(bytes); i++ {
           bytes[i] = 100
         }
       http.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
           w.Write(bytes)
           })
       http.ListenAndServe(":8000", nil)
}

