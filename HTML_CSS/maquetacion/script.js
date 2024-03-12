let slideIndex = 0;

    function showSlides() {
        const slides = document.querySelectorAll('.carousel img');
        if (slideIndex >= slides.length) {
            slideIndex = 0;
        } else if (slideIndex < 0) {
            slideIndex = slides.length - 1;
        }
        slides.forEach(slide => slide.style.display = "none");
        slides[slideIndex].style.display = "block";
    }

    function prevSlide() {
        slideIndex--;
        showSlides();
    }

    function nextSlide() {
        slideIndex++;
        showSlides();
    }

    showSlides();


