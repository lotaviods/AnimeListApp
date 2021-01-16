const gulp = require('gulp');
const terser = require('gulp-terser');
const concat = require('gulp-concat');

function es() {
    return gulp.src(['app/js/*.js', 'app/js/services/*.js', 'app/js/controllers/*.js'])
        .pipe(concat('all.js'))
        .pipe(terser({
            keep_fnames: false,
            mangle: false
        }))
        .pipe(gulp.dest('public/js'));
}

gulp.task('default', es);