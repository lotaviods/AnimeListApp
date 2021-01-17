const gulp = require('gulp');
const concat = require('gulp-concat');
const terser = require('gulp-terser');
const cleanCSS = require('gulp-clean-css');
const sourcemaps = require('gulp-sourcemaps');

gulp.task('js', function() {
    return gulp.src(['app/*.js', 'app/services/*.js', 'app/directives/*.js', 'app/controllers/*.js'])
        .pipe(concat('all.js'))
        .pipe(sourcemaps.init())
        .pipe(terser({
            keep_fnames: false,
            mangle: true
        }))
        .pipe(sourcemaps.write('/'))
        .pipe(gulp.dest('public/js'));
});
gulp.task('css', function() {
    return gulp.src('app/css/*.css')
        .pipe(sourcemaps.init())
        .pipe(cleanCSS())
        .pipe(sourcemaps.write('/'))
        .pipe(gulp.dest('public/css'));
});