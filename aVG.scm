#|
Author: Elizabeth Ralyea
Date: 03/06/2018
Purpose: To find the average of a set of numbers given by the user.
|#

#|
Function Name: get-Filename
Purpose: asks user for Filename
Input: user given Filename
Output: filename
|#
(define (get-filename)
  (newline)
  (display "Please enter Filename: ")
  (read-line))

#|
Function Name: average
Purpose: gets the sum of the list of numbers and then divides by the length of
the list
Input: sent a list
Output: the average of the list
|#
(define (average list)
    (/ (reduce + 0 list) (length list))) ;;; Finds average of a list

#|
Function Name: get-numbers
Purpose: reads a file of all of the numbers
Input: file path
Output: list of numbers
|#
(define (get-numbers)
  (define path (get-filename))
  (define results (call-with-input-file path
    (lambda (p)
      (define (loop line acc)
        (if (eof-object? line)
            acc
            (if (string->number line)
              (loop (read-line p) (cons (string->number line) acc))
              (begin
                (fresh-line)
                (display (string-append "Found non number: " line "\n"))
                (loop (read-line p) acc)))))
      (loop (read-line p) (list)))))
  results)

  (define numbers (get-numbers))
  ;;;above statement sets numbers equal to the list returned by get-numbers

#|
Purpose of code segment: to check for any empty lists
|#
(if (= (length numbers) 0)
  (display "No numbers found!")
  (let ((average-val (exact->inexact (average numbers))))
;;;above statement converts exact average into decimal if list is not empty
  (display (string-append "Average value: " (number->string average-val)))))
;;;above statement displays the average of the given list of numbers
