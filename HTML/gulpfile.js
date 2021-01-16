const gulp = require('gulp');
const concat = require('gulp-concat');
const terser = require('gulp-terser');
gulp.task('dev', function() {
    return gulp.src(['app/js/*.js', 'app/js/services/*.js', 'app/js/controllers/*.js']) // get source files with gulp.src
        .pipe(concat('all.js'))
        .pipe(terser({
            keep_fnames: false,
            mangle: true
        }))
        .pipe(gulp.dest('public/js'));
});